package ua.artcode.week5.threads;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by serhii on 09.01.16.
 */
public class FutureWithExServiceFinder {

    // manager
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(20);

        File userHome = new File("/home/serhii/dev");

        Collection<Callable<List<String>>> tasks = new ArrayList<>();
        for(File f : userHome.listFiles()){
            if(f.isDirectory()){
                tasks.add(new WorkerThread(f, "Thread"));
            }
        }


        try {
            List<Future<List<String>>> futures = executorService.invokeAll(tasks);

            executorService.shutdown();
            while(!executorService.isTerminated()){
                executorService.awaitTermination(5,TimeUnit.SECONDS);
            }

            List<String> res = new ArrayList<>();

            for (Future<List<String>> future : futures) {
                try {
                    List<String> futureRes = future.get();
                    for (String futureRe : futureRes) {
                        res.add(futureRe);
                    }
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }


            res.stream().forEach(System.out::println);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }




    }


    static class  WorkerThread implements Callable<List<String>> {

        private List<String> res;
        private File folder;
        private String searchWord;

        public WorkerThread(File folder, String searchWord) {
            this.folder = folder;
            this.searchWord = searchWord;

            res = new ArrayList<>();
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
                        throw new NullPointerException();
                    }
                }
            }
        }

        @Override
        public List<String> call() throws Exception {
            search(folder);
            return res;
        }
    }


}

