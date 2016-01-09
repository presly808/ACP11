package ua.artcode.week5.threads;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by serhii on 09.01.16.
 */
public class JoinTest {


    private static Thread last;

    // manager
    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();

        List<WorkerThread> workerThreads = new ArrayList<>();

        File userHome = new File("/home/serhii/dev");
        long start = System.currentTimeMillis();

        for(File f : userHome.listFiles()){
            if(f.isDirectory()){

                WorkerThread target = new WorkerThread(f, "Thread");
                workerThreads.add(target);

                Thread thread = new Thread(target);
                threads.add(thread);
                thread.start();
            }
        }

        /*WorkerThread target = new WorkerThread(userHome, "Thread");
        workerThreads.add(target);

        Thread thread1 = new Thread(target);
        threads.add(thread1);
        thread1.start();*/


        //
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);

        for (WorkerThread workerThread : workerThreads) {
            workerThread.getRes().stream().forEach(System.out::println);
        }



    }

    static class WorkerThread implements Runnable {

        private List<String> res;
        private File folder;
        private String searchWord;

        public WorkerThread(File folder, String searchWord) {
            this.folder = folder;
            this.searchWord = searchWord;

            res = new ArrayList<>();
        }

        @Override
        public void run() {
            search(folder);
        }

        private void search(File dir){
            File[] sub = dir.listFiles();
            if(sub != null){
                for (File file : sub) {
                    if(file.isDirectory()){
                        search(file);
                    }
                    if(file.getName().contains(searchWord)){
                        res.add(file.getAbsolutePath());
                    }
                }
            }
        }

        public List<String> getRes(){
            return res;
        }
    }


}

