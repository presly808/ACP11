package week5_Max.fileSearch;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolSearch {
    private ExecutorService executorService;
    private File root;
    private String searchWord;


    public ThreadPoolSearch(String path, int pools, String searchWord) {
        root = new File(path);
        this.searchWord = searchWord;
        executorService = Executors.newFixedThreadPool(pools);
    }

    public void search() {
        Collection<Callable<List<String>>> coll = new ArrayList<>();
        for (File file : root.listFiles()) {
            if (file.isDirectory()) {
                coll.add(new FileSeacher(searchWord, file));
            }
        }
        try {
            List<Future<List<String>>> links = executorService.invokeAll(coll);
            executorService.shutdown();
            while (!executorService.isTerminated()) {
                executorService.awaitTermination(5, TimeUnit.SECONDS);
            }

            for (Future<List<String>> future : links) {
                future.get().stream().forEach(System.out::println);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}


class FileSeacher implements Callable<List<String>> {
    private File root;
    private String word;
    private List<String> res;

    public FileSeacher(String word, File root) {
        this.word = word;
        this.root = root;
        res = new ArrayList<>();
    }

    private void search(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    search(file);
                }
                if (file.getName().contains(word)) {
                    res.add(file.getAbsolutePath());
                }
            }
        }
    }

    @Override
    public List<String> call() throws Exception {
        search(root);
        return res;
    }
}
