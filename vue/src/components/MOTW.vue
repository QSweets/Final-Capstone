<template>
  <div>
    <button v-on:click="getRandomMonster">Get Random Monster</button>
    <div v-if="randomMonster">
      <p>Name: {{ randomMonster.name }}</p>
      <p>index: {{ randomMonster.index }}</p>
      <p>Size: {{ randomMonster.details.size }}</p>
      <p>Challenge Rating: {{ randomMonster.details.challenge_rating }}</p>
      <p>Special Abilities: {{ randomMonster.details.special_abilities }}</p>
      <img :src="monsterImageUrl" alt="Monster Image" />
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
  computed: {
  monsterImageUrl() {
    if (this.randomMonster) {
      const index = this.randomMonster.index.toLowerCase();
      return `https://www.dnd5eapi.co/api/images/monsters/${index}.png`;
    }
    return '';
  },
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
