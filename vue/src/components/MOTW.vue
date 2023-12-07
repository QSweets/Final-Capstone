<template>
<<<<<<< HEAD
  <div>
    <button v-on:click="getRandomMonster">Get Random Monster</button>
    <div v-if="randomMonster">
      <p>Name: {{ randomMonster.name }}</p>
      <p>Size: {{ randomMonster.details.size }}</p>
      <p>Challenge Rating: {{ randomMonster.details.challenge_rating }}</p>
      <p>Special Abilities: {{ randomMonster.details.special_abilities }}</p>
=======
    <div>
      <button v-on:click="getRandomMonster">Get Random Monster</button>
      <div v-if="randomMonster">
        <p>Name: {{ randomMonster.name }}</p>
        <img v-if="randomMonster.image" :src="randomMonster.image" alt="Monster image" />
      </div>
>>>>>>> 5ff9724892be829efb14f2ce00ce4b6a4fccbaea
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
