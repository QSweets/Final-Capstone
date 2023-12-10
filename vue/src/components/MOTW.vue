<template>
  <div>
    <div class="m-stats" v-if="randomMonster">
      <p id="m-name">Name: {{ randomMonster.name }}</p>
      <p id="m-size">Size: {{ randomMonster.details.size }}</p>
      <p id="m-challenge">Challenge Rating: {{ randomMonster.details.challenge_rating }}</p>
      <p id="m-abilities">Special Abilities: {{ randomMonster.details.special_abilities }}</p>
      <img id="m-img" :src="monsterImageUrl" alt="Monster Image" />
    </div>
    <button class="r-monster" v-on:click="getRandomMonster">Get Random Monster</button>
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

<style>
.r-monster {
  display: flex;
  position: absolute;
  bottom: 6.5vh;
  right: 44%;
}
  .m-stats {
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: start;
  width: 87%;
  top: 14.4%;
  position: absolute;
  left: 17vh;
}
#m-name {
  border: solid 2px;
  position: absolute;
  top: 7.8vh;
  left: 10vh;
  padding-left: .5%;
  padding-right: .5%;
}
#m-size {
  border: solid 2px;
  position: absolute;
  top: 7.8vh;
  left: 50vh;
  padding-left: .5%;
  padding-right: .5%;
}
#m-challenge {
  border: solid 2px;
  position: absolute;
  top: 7.8vh;
  left: 85vh;
  padding-left: .5%;
  padding-right: .5%;
}
#m-abilities {
  border: solid 2px;
  position: absolute;
  top: 14vh;
  left: 1.5vh;
  width: 60vh;
  height: 52.8vh;
  overflow: scroll;
  padding-left: .5%;
}
#m-img {
  width: 52.7vh;
  position: absolute;
  top: 15.7vh;
  left: 62.9vh;
  height: 53.1vh;
}
</style>