<template>
  <p>This is my Profile page</p>
  <h3>My Party</h3>
  <div class="img">
    <a href="https://www.dnd5eapi.co/"><img src="src\ProfileImages\ProfileWall.png"></a>
  </div>
  <div class="Character-creation-form">
  <button v-on:click="toggleForm">Add Character</button>

  <form v-on:submit.prevent="submitCharacter">
    <div>
      <label for="picture">Picture</label>
      <input type="file" id="picture" name="picture" />
    </div>
    <div>
      <label for="characterName">Character Name:</label>
      <input type="text" id="characterName" name="characterName" required/>
    </div>
    <div>
      <label for="creature">Creature:</label>
      <select id="creature" v-model="creature" required>
         <option value="Dwarves">Dwarves</option>
         <option value="Elves">Elves</option>
         <option value="Halflings">Halflings</option>
         <option value="Humans">Humans</option>
         <option value="Dragonborns">Dragonborns</option>
         <option value="Gnomes">Gnomes</option>
         <option value="Half-elves">Half-elves</option>
         <option value="Half-orcs">Half-orcs</option>
         <option value="Tieflings">Tieflings</option>
      </select>
    </div>
    <div>
      <label for="characterClass">Character Class:</label>
      <select v-model="characterClass" id="characterClass" required>
        <option value="Barbarian">Barbarian</option>
        <option value="Bard">Bard</option>
        <option value="Cleric">Cleric</option>
        <option value="Druid">Druid</option>
        <option value="Fighter">Fighter</option>
        <option value="Monk">Monk</option>
        <option value="Paladin">Paladin</option>
        <option value="Ranger">Ranger</option>
        <option value="Rogue">Rogue</option>
        <option value="Sorcerer">Sorcerer</option>
        <option value="Warlock">Warlock</option>
        <option value="Wizard">Wizard</option>
      </select>
    </div>
    <div>
      <label for="rolledStats">Rolled Stats:</label>
      <input type="text" id="rolledStats" name="rolledStats" />
    </div>
    <div>
      <label for="ability1">Ability 1:</label>
      <textarea v-model="text"></textarea> 
    </div>
    <div>
      <label for="ability2">Ability 2:</label>
      <textarea v-model="text"></textarea> 
    </div>
    <div>
      <label for="ability3">Ability 3:</label>
      <textarea v-model="text"></textarea> 
    </div>
    <div>
      <label for="ability4">Ability 4:</label>
      <textarea v-model="text"></textarea> 
    </div>
    <div>
      <label for="background">Background:</label>
      <textarea v-model="text"></textarea> 
    </div>

    <button type="submit" class="save btn">Save Character</button>
    
  </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      picture: null,
      characterName: '',
      creature: '',
      rolledStats: '',
      ability1: '',
      ability2: '',
      ability3: '',
      ability4: '',
      background: '',
    };
  },

  methods: {
    async submitCharacter(){
      try {
        const formData = new formData();
        formData.append('picture', this.picture);
        formData.append('characterName', this.characterName);
        formData.append('creature', this.creature);
        formData.append('rolledStats', this.rolledStats);
        formData.append('ability1', this.ability1);
        formData.append('ability2', this.ability2);
        formData.append('ability3', this.ability3);
        formData.append('ability4', this.ability4);
        formData.append('background', this.background);

        await axios.post('http://localhost:9000/users/character', formData, {
          headers: {
            'Content-Type' : 'multipart/form-data',
          },
        });

        console.log('Character Saved!');
      } catch (error) {
        console.error('Error saving character', error);
      }
    }
  }
}
</script>

<style>
.img{
  background-image: url('../loginImages/LoginBG3.png');
  background-repeat: no-repeat;
}
<<<<<<< HEAD
</style>
=======
</style>
>>>>>>> f6b32e9e81132d81b0c7cabf80c2ce3cba9464a0
