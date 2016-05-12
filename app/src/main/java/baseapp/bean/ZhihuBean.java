package baseapp.bean;

import java.util.List;

/**
 * Created by zcm on 2016/4/7.
 * qq:656025633
 */
public class ZhihuBean {
    /**
     * date : 20160407
     * stories : [{"ga_prefix":"040712","id":8118219,"images":["http://pic4.zhimg.com/88b40ccea5bb2bb85db006add4daca3b.jpg"],"title":"这篇文章，只是在用几个值得尊敬的例子来愚昧大众","type":0},{"ga_prefix":"040711","id":8118151,"images":["http://pic1.zhimg.com/3c78356485e93214ea88e3804c74e7d0.jpg"],"title":"遇到类似「酒店遇袭事件」，这些投诉渠道很有用","type":0},{"ga_prefix":"040710","id":8117193,"images":["http://pic3.zhimg.com/ded0b2c2ae94304173ddd1ad61668a86.jpg"],"title":"感染艾滋病是一种怎样的经历？","type":0},{"ga_prefix":"040709","id":8114135,"images":["http://pic3.zhimg.com/df47bd5e8f111885c2402e6f8aee8bca.jpg"],"title":"社保费率又下调，以后靠社保还养得起老吗？","type":0},{"ga_prefix":"040708","id":8115731,"images":["http://pic1.zhimg.com/fe43c150bdbd01e2b259fb3fd9e952a8.jpg"],"title":"年轻人得了老人的「痴呆症」，是有可能传染的","type":0},{"ga_prefix":"040707","id":8116375,"images":["http://pic3.zhimg.com/aa5fca9d8a601bc3f293ac00001f24e6.jpg"],"title":"研究表明，想让农民起义少点儿，多吃红薯吧","type":0},{"ga_prefix":"040707","id":8112423,"images":["http://pic3.zhimg.com/60fa11e8669df8660e32b0f6f7d2b63a.jpg"],"title":"我知道你想上天，所以我先上去帮你看看","type":0},{"ga_prefix":"040707","id":8115590,"images":["http://pic3.zhimg.com/ac37a7ab4eb15df00ea44d677f884b5a.jpg"],"title":"这些讨厌的寄生虫，到底有什么存在的意义\u2026\u2026","type":0},{"ga_prefix":"040707","id":8116282,"images":["http://pic1.zhimg.com/bce922b4d7bf2582093e512bc89d6a6c.jpg"],"title":"读读日报 24 小时热门 TOP 5 · 陌生人强行拖拽你，如何有效呼救","type":0},{"ga_prefix":"040706","id":8114806,"images":["http://pic4.zhimg.com/255832d68abb6a72e0e047c32c435317.jpg"],"title":"瞎扯 · 如何正确地吐槽","type":0}]
     * top_stories : [{"ga_prefix":"040711","id":8118151,"image":"http://pic3.zhimg.com/343294d8fd4d6eda2e707f4b2dd49b4a.jpg","title":"遇到类似「酒店遇袭事件」，这些投诉渠道很有用","type":0},{"ga_prefix":"040710","id":8117193,"image":"http://pic2.zhimg.com/b85c9d1b59fe8353875fe19579a9d979.jpg","title":"感染艾滋病是一种怎样的经历？","type":0},{"ga_prefix":"040707","id":8116282,"image":"http://pic2.zhimg.com/1f109117d853c4d7b2f8e36a9e1a1e85.jpg","title":"读读日报 24 小时热门 TOP 5 · 陌生人强行拖拽你，如何有效呼救","type":0},{"ga_prefix":"040709","id":8114135,"image":"http://pic1.zhimg.com/069f3fc852a2cf6ce844c6f768740178.jpg","title":"社保费率又下调，以后靠社保还养得起老吗？","type":0},{"ga_prefix":"040621","id":7814996,"image":"http://pic1.zhimg.com/69f77402231cc07d2fcaf232f9e601dc.jpg","title":"暴力、搞笑、B 级片，黑帮的故事充满了江湖气息","type":0}]
     */

    private String date;
    /**
     * ga_prefix : 040712
     * id : 8118219
     * images : ["http://pic4.zhimg.com/88b40ccea5bb2bb85db006add4daca3b.jpg"]
     * title : 这篇文章，只是在用几个值得尊敬的例子来愚昧大众
     * type : 0
     */

    private List<StoriesBean> stories;
    /**
     * ga_prefix : 040711
     * id : 8118151
     * image : http://pic3.zhimg.com/343294d8fd4d6eda2e707f4b2dd49b4a.jpg
     * title : 遇到类似「酒店遇袭事件」，这些投诉渠道很有用
     * type : 0
     */

    private List<TopStoriesBean> top_stories;

    public ZhihuBean() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }


    public static class StoriesBean {
        private String ga_prefix;
        private int id;
        private String title;
        private int type;
        private List<String> images;

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        private String ga_prefix;
        private int id;
        private String image;
        private String title;
        private int type;

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
