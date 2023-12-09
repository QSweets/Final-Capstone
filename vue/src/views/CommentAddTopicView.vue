<template>
    <h1>Add New Topic</h1>
    <comment-topic-form v-bind:topic="topic" />
  </template>
  
  <script>
  import CommentTopicForm from '../components/CommentTopicForm.vue';
  
  export default {
    components: {
      CommentTopicForm
    },
    data() {
      return {
        // Default data for a new topic
        topic: {
          id: 0,
          title: '',
          date: new Date(),
        },
      }
    } 
  };
  </script>
  
  <style scoped>
  </style>