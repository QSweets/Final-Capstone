<template>
    <header class="flex">
      <h1>Let's Talk About It</h1>
    </header>
      <button class="btn-add" v-on:click="$router.push({ name: 'CommentAddMessageView' })">Add Comment</button>
    <comment-message-summary v-for="message in messages" v-bind:key="message.id" v-bind:message="message" />
  </template>
  
  <script>
  import CommentMessageSummary from '../components/CommentMessageSummary.vue';
  import MessageService from '../services/MessageService'
  import axios from 'axios';
  
  export default {
    components: {
      CommentMessageSummary, 
    },
    
    props: {
      message: {
        type: Object,
        required: true
      },
    
    }
    };

  </script>
  
  <style scoped>
  /* header {
    margin-bottom: 1rem;
  }
  h2 {
    font-size: large;
  }
  .created {
    margin-bottom: 1rem;
  } */
  </style>
  