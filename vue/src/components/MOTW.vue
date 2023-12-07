<template>
  <div>
    <button v-on:click="getRandomMonster">Get Random Monster</button>
    <div v-if="randomMonster">
      <p>Name: {{ randomMonster.name }}</p>
      <p>Size: {{ randomMonster.details.size }}</p>
      <p>Challenge Rating: {{ randomMonster.details.challenge_rating }}</p>
      <p>Special Abilities: {{ randomMonster.details.special_abilities }}</p>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      randomMonster: null,
    };
  },
  methods: {
    getRandomMonster() {
      axios.get('/api/monsters/random')
        .then(response => {
          this.randomMonster = response.data;
        })
        .catch(error => {
          console.error('Error fetching random monster:', error);
        });
    },
  },
};
</script>
