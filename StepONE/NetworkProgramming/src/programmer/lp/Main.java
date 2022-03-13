package programmer.lp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
//    private static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws Exception {
        Document doc = Jsoup.connect("https://ext.se.360.cn/webstore/category").get();
        Elements appWraps = doc.select(".appwrap");
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < appWraps.size(); i++) {
            Element e = appWraps.get(i);
            String appImg = e.selectFirst("img").attr("src");
            String appName = e.selectFirst("h3").text();
            if (i != 0) {
                sb.append(",");
            }
            sb.append(toJSON(appImg, appName));
        }
        sb.append("]");
        System.out.println(sb.toString());
//        } finally {
//            THREAD_POOL.shutdown();
//        }
    }

    private static String toJSON(String url, String name) {
        return "{\"name\":\"" + name + "\",\"img\":\"" + url + "\"}";
    }

//    private static void downloadImage(String url, String name) {
//        THREAD_POOL.execute(() -> {
//            try {
//                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
//                connection.setRequestMethod("GET");
//                connection.setDoInput(true);
//                connection.setUseCaches(false);
//                connection.setConnectTimeout(30000);
//                connection.setReadTimeout(30000);
//                connection.connect();
//                try (
//                        final InputStream inputStream = connection.getInputStream();
//                        final OutputStream outputStream = new FileOutputStream("C:\\Users\\lpruoyu\\Desktop\\image\\" + name + ".png")
//                ) {
//                    byte[] bytes = new byte[10240];
//                    int len;
//                    while ((len = inputStream.read(bytes)) != -1) {
//                        outputStream.write(bytes, 0, len);
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//    }
}
