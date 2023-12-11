
<template>
  <div class="loading" v-if="isLoading">
    <p>Loading...</p>
  </div>
  <div >
    <header class="flex">
      <h1>Topics</h1>
      <button class="btn-add" v-on:click="$router.push({ name: 'CommentAddTopicView' })">Add Topic</button>
    </header>
    <comment-topic-list v-bind:topics="topics"/>
  </div>
</template>

<script>
import GlobalLogoHeader from '../components/GlobalLogoHeader.vue';
import topicService from '../services/TopicService.js';
import CommentTopicList from '../components/CommentTopicList.vue';

export default {
  components: {
    // GlobalLogoHeader,
    CommentTopicList
},
data() {
    return {
      topics: [],
      isLoading: true
    };
  },
  methods: {
    getTopics() {
      topicService.list()
        .then(response => {
          this.topics = response.data;
          this.isLoading = false;
        })
        .catch(error => {
          this.handleError();
        })
    },
    handleErrorResponse() {
      this.isLoading = false;
      this.$store.commit('SET_NOTIFICATION', `Could not get topic data from server.`);
    }
  },
  created() {
    this.getTopics();
  }
 
};
</script>

<style>

h1 {
  justify-content: center;
  
}
/* body {
  font-family: Arial, sans-serif;
  margin: 0 auto;
}
h1, h2, h3, h4, h5, h6 {
  margin: 0;
}
h1 span {
  font-size: large;
}
header {
  margin-bottom: 1rem;
}
h2 {
  font-size: large;
}
textarea {
   font-family: inherit;
   font-size: inherit;
}
.app-header {
  background-color: rgb(60, 60, 60);
  color: white;
  text-align: center;
  margin-bottom: 2rem;
  padding: 0.5rem;
  cursor: pointer;
}
main {
  width: 100%;
  max-width: 800px;
  margin: 0 auto;
}
nav {
  margin-bottom: 2rem;
}
nav a {
  font-size: large;
  display: inline-block;
  padding-right: 10px;
}
nav a:link, nav a:visited {
  color: black;
  text-decoration: none;
}
nav a:hover {
  color: rgb(70, 70, 245);
  cursor: pointer;
}
.flex {
  display: flex;
  align-items: baseline;
  justify-content: space-between;
  margin-bottom: 1rem;
}
button {
  border-radius: 5px;
  font-weight: bold;
  margin-right: 1rem;
  padding: 5px;
}
button:hover {
  border-color: #bababa;
}
.btn-add {
  background: #c4eec4;
}
.btn-delete {
  background: #f0c4c4;
}
.status-message {
  background-color: #bababa;
  display: block;
  border-radius: 5px;
  font-weight: bold;
  font-size: 1rem;
  text-align: center;
  padding: 10px;
  margin-bottom: 10px;
  cursor: pointer;
}
.status-message.success {
  background-color: #90ee90;
}
.status-message.error {
  background-color: #f08080;
}
   */
</style>
