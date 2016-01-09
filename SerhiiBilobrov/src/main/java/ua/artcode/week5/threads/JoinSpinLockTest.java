package ua.artcode.week5.threads;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by serhii on 09.01.16.
 */
public class JoinSpinLockTest {

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

        for (WorkerThread workerThread : workerThreads) {
            workerThread.getRes().stream().forEach(System.out::println);
        }



    }


    static class  WorkerThread implements Runnable {

        private List<String> res;
        private File folder;
        private String searchWord;
        private volatile boolean done = false;

        public WorkerThread(File folder, String searchWord) {
            this.folder = folder;
            this.searchWord = searchWord;

            res = new ArrayList<>();
        }

        @Override
        public void run() {
            search(folder);
            done = true;
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
            while(!done){}

            return res;
        }
    }


}

