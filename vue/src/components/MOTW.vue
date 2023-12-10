<template>
  <div>
    <button class="r-monster" v-on:click="getRandomMonster">Get Random Monster</button>
    <div class="m-stats" v-if="randomMonster">
      <p id="m-name">Name: {{ randomMonster.name }}</p>
      <p id="m-size">Size: {{ randomMonster.details.size }}</p>
      <p id="m-challenge">Challenge Rating: {{ randomMonster.details.challenge_rating }}</p>
      <p id="m-abilities">Special Abilities: {{ randomMonster.details.special_abilities }}</p>
      <img id="m-img" :src="monsterImageUrl" alt="Monster Image" />
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
