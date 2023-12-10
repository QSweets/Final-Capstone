<template>
    <!-- <div class="loading" v-if="isLoading">
      <p>Loading...</p>
    </div> -->
    <div >
      <header class="flex">
        <h1>Topics</h1>
        <button class="btn-add" v-on:click="$router.push({ name: 'CommentAddMessageView' })">Add Topic</button>
      </header>
      <message-service v-bind:topics="topics"/>
    </div>
  </template>
  
  <script>
  import messageService from '../services/MessageService.js';
  
  export default {
    components: {
      messageService,
    },
    data() {
      return {
        topics: [],
        isLoading: true
      };
    },
    methods: {
      getTopics() {
        messageService.list()
          .then(response => {
            this.messages = response.data;
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