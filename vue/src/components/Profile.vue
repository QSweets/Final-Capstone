<template>
  <p>This is my Profile page</p>
  <h3>My Party</h3>
  <div class="img">
    <a href="https://www.dnd5eapi.co/"><img src="src\ProfileImages\ProfileWall.png"></a>
  </div>

  <button v-on:click="toggleForm">Add Character</button>

  <form>
    <div>
      <label for="picture">Picture</label>
      <input type="img" id="picture" name="picture" />
    </div>
    <div>
      <label for="name">Name:</label>
      <input type="text" id="name" name="name" />
    </div>
    <div>
      <label for="race">Race:</label>
      <select type="text" id="race" name="race">

      </select>
    </div>
    <div>
      <label for="characterClass">Character Class:</label>
      <select v-model="characterClass" id="characterClass">

      </select>
    </div>
    <div>
      <label for="rolledStats">Rolled Stats:</label>
      <input type="text" id="rolledStats" name="rolledStats" />
    </div>
    <div>
      <label for="spells">Spells:</label>
      <input type="text" id="spells" name="spells" />
    </div>
    <div>
      <label for="background">Background:</label>
      <input type="textarea" id="background" name="background" />
    </div>

    <button type="submit" class="save btn">Save Character</button>

  </form>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      selectedOption: null,
    };
  },
  computed: {
  classNames() {
    if (this.selectedOption) {
      const index = this.selectedOption.index.toLowerCase();
      return `https://www.dnd5eapi.co/api/classes/${index}`;
    }
    return '';
  },
},
  methods: {
    getClass() {
      axios.get('/api/classes')
        .then(response => {
          this.selectedOption = response.data;
        })
        .catch(error => {
          console.error('Error fetching character classes:', error);
        });
    },
  },
};
</script>

<style>
.img{
  background-image: url('../loginImages/LoginBG3.png');
  background-repeat: no-repeat;
}
</style>