<template>
  <div class="social">
    <!-- <header class="app-header" v-on:click="$router.push({name: 'CommentHomeView'})"></header> -->
    <h1>Let's Talk About It</h1>
    <!-- This is to navigate to the homepage -->
    <router-link to="/" v-if="$store.state.token !== ''">Home</router-link> &nbsp; | &nbsp;
    <!-- navigate to the "logout" route -->
    <router-link to="/logout" v-if="$store.state.token !== ''">Logout</router-link>
  </div>
  <!-- <GlobalLogoHeader /> -->
  <CommentHomeView />
  <main>
    <div v-bind:class="notificationClass" v-show="notification" v-on:click="clearNotification">
      {{ notification?.message }}
    </div>
    <router-view />
  </main>
</template>
  
  <script>
  import topicService from '../services/TopicService.js';
  import CommentTopicList from '../components/CommentTopicList.vue';
  
  export default {
    components: {
     // CommentTopicList
      
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
  }
  </script>
  
  <style scoped>
  </style>