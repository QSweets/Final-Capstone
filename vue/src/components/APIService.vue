<template>
    <div></div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    methods: {
      getRandomMonster() {
        return axios.get('http://localhost:9000/api/monsters/random')
          .then(response => response.data)
          .catch(error => {
            console.error('Error fetching random monster:', error);
            throw error;
          });
      }
    }
  };
  </script>
  