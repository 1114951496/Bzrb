package cn.mk95.www.bzrb;

        import com.google.gson.Gson;

        import org.junit.Test;

        import java.io.IOException;

        import cn.mk95.www.bzrb.model.IndexPageOneDataEntity;
        import cn.mk95.www.bzrb.model.NewsDataEntity;
        import cn.mk95.www.bzrb.utils.MyUrl;
        import okhttp3.OkHttpClient;
        import okhttp3.Request;
        import okhttp3.Response;
/**
 * Created by 睡意朦胧 on 2017/6/8.
 */

public class Htest {
    @Test
    public void NewsoneTest() {
        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();
        NewsDataEntity newsDataEntity = null;
        Request request = new Request.Builder()
                .url("http://dailyapi.ibaozou.com/api/v31/documents/46741")
                .build();
        try {
            Response response = client.newCall(request).execute();
            newsDataEntity = gson.fromJson(response.body().string(), NewsDataEntity.class);
        } catch (IOException e) {

        } finally {
            if (newsDataEntity == null) {
                System.out.println("失败");
            } else {
                System.out.println(newsDataEntity.getBody().toString());
            }
        }
    }
}
