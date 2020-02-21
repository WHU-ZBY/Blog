<template>
  <div class="pageWrap">
    <topbar></topbar>
    <div class="mainPageWrap">
      <!-- <a-button type="primary" class="loginButton" @click="getArticleList">获取</a-button> -->
      <a-row>
        <a-col :span="4" class="backgroundClass"></a-col>
        <a-col :span="16" class="articleWrap">
          Article List
          <div class="articleList" v-for="(item) in articleList" :key="item.id" @click="toArticle(item.article_id)">
            <div class="articlePartWrap">
              <br />
              <div class="articleHoverWrap">
                <div class="articleTitle">{{item.title}}</div>
                <div class="articleIntro">{{item.intro}}</div>
                <div class="articleDate">{{item.createDate}}</div>
              </div>
              <br />
              <hr class="hrClass" />
            </div>
          </div>
        </a-col>
        <a-col :span="4" class="backgroundClass"></a-col>
      </a-row>
    </div>
    <bottomBar></bottomBar>
  </div>
</template>
<script>
import bottomBar from "../components/wrap/bottomBar";
import topbar from "../components/wrap/topBar";
// 使用组件的时候，使用的是components里面的名字
export default {
  name: "mainPage",
  components: {
    topbar,
    bottomBar
  },
  data() {
    return {
      articleList: []
    };
  },
  methods: {
    getArticleList() {
      this.axios
        .get("http://106.15.182.82:8080/article/getArticleIntroByUid", {
          params: { uid: this.$store.state.uid }
        })
        .then(response => {
          this.articleList = response.data;
        })
        .catch(function(error) {
          console.log(error);
        });
    },
     toArticle(article_id){
          console.log(article_id);
          this.$router.push({ name: "articlePage",query:{articleId:article_id} });
      }
  },
  created() {
    this.axios
      .get("http://106.15.182.82:8080/article/getArticleIntroByUid", {
        params: { uid: this.$store.state.uid }
      })
      .then(response => {
        this.articleList = response.data;
        console.log(this.articleList);
      })
      .catch(function(error) {
        console.log(error);
      });
  }
};
</script>
<style scoped>
.pageWrap {
  margin-top: -2px;
}
.pageWrap {
  width: 100%;
  overflow: auto;
  height: 100%;
  position: fixed;
  background-color: #34495e;
}
.articleList {
  margin-top: 5%;
}
.articleWrap {
  font-family: cursive;
  color: white;
  font-size: 26px;
  text-align: center;
  margin-top: 7%;
}
.hrClass{
    width: 40%;
    color: #95a5a6;
}
.articlePartWrap{
    font-size: 20px;
}
.articleTitle{
  font-size: 24px;
}
.articleHoverWrap{
    cursor: pointer;
     transition:all .3s;
}
.articleHoverWrap:hover{
   	transform:scale(1.1);
}
.articleDate,.articleIntro{
    color: #95a5a6;
}
</style>