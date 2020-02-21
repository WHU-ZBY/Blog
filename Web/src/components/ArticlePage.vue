<!-- articlePage -->
<template>
  <div class="articlePageWrap">
    <topbar></topbar>
    <a-row>
      <a-col :span="6" class="leftPart"></a-col>
      <a-col :span="12" class="articleWrap">
        <div class="articleTitle">{{this.article.title}}</div>
        <div class="articleInfo">
            <div class="articleIntro">简介： {{this.article.intro}}</div>
           <div class="articleDate">时间：{{this.article.createDate}}</div>
          </div>
       
        <br />
        <p class="articleContent" v-html="article.content">
          {{this.article.content}}
        </p>
      </a-col>
      <a-col :span="6" class="rightPart"></a-col>
    </a-row>
    <bottomBar></bottomBar>
  </div>
</template>

<script>
//这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
//例如：import 《组件名称》 from '《组件路径》';
import topbar from "../components/wrap/topBar";
import bottomBar from "../components/wrap/bottomBar";
export default {
  name: "articlePage",
  //import引入的组件需要注入到对象中才能使用
  components: {
    topbar,
    bottomBar
  },
  data() {
    //这里存放数据
    return {
      article:''
    };
  },
  //监听属性 类似于data概念
  computed: {},
  //监控data中的数据变化
  watch: {},
  //方法集合
  methods: {
    getArticleId()
    {
      let articleId = this.$route.query.articleId;
       this.axios
      .get("http://106.15.182.82:8080/article/getArticleByArticleId", {
        params: { articleId: articleId }
      })
      .then(response => {
        this.article = response.data;
        console.log(this.article);
      })
      .catch(function(error) {
        console.log(error);
      });
    }
  },
  //生命周期 - 创建完成（可以访问当前this实例）
  created() {
    this.getArticleId();
  },
  //生命周期 - 挂载完成（可以访问DOM元素）
  mounted() {},
  beforeCreate() {}, //生命周期 - 创建之前
  beforeMount() {}, //生命周期 - 挂载之前
  beforeUpdate() {}, //生命周期 - 更新之前
  updated() {}, //生命周期 - 更新之后
  beforeDestroy() {}, //生命周期 - 销毁之前
  destroyed() {}, //生命周期 - 销毁完成
  activated() {} //如果页面有keep-alive缓存功能，这个函数会触发
};
</script>
<style scoped>
.articlePageWrap {
  display: block;
  width: 100%;
  overflow: auto;
  height: 100%;
  position: fixed;
  background: url("../assets/image/background/bg2.jpg") right no-repeat;
  background-size: 18%;
}
.articleWrap {
  margin-top: 5%;
  min-height: 400px;
}
.articleTitle {
  font-size: 36px;
  text-align: center;
  font-family: Arial, Helvetica, sans-serif;
}
.articleInfo {
  font: bold;
  color: #95a5a6;
  text-align:left;
  margin-top: 5%;
}
.articleIntro{
  font-size: 18px;
}
.articleDate{
  font-size: 18px;
}
.articleContent {
  font-size: 22px;
}
</style>