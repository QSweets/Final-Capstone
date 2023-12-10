<template>
  <p>This is my Profile page</p>
  <h3>My Party</h3>
  <div class="img">
    <!-- <a href="https://www.dnd5eapi.co/"><img src="src\ProfileImages\ProfileWall.png"></a> -->
  </div>
  <div class="Character-creation-form">
  <button v-on:click="toggleForm">Add Character</button>
  <div v-if="showForm" class="popup-form">
  <form v-on:submit.prevent="submitCharacter">
    <div>
      <label for="picture">Picture:</label>
      <input type="file" id="picture" name="picture" v-on:change="onFileChange" />
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
      <label for="profession">Profession:</label>
      <select v-model="profession" id="profession" required>
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
      <label for="strength">Strength:</label>
      <input type="text" id="strength" name="strength" />
    </div>
    <div>
      <label for="dexterity">Dexterity:</label>
      <input type="text" id="dexterity" name="dexterity" />
    </div>
    <div>
      <label for="constitution">Constitution:</label>
      <input type="text" id="constitution" name="constitution" />
    </div>
    <div>
      <label for="intelligence">Intelligence:</label>
      <input type="text" id="intelligence" name="intelligence" />
    </div>
    <div>
      <label for="wisdom">Wisdom:</label>
      <input type="text" id="wisdom" name="wisdom" />
    </div>
    <div>
      <label for="charisma">Charisma:</label>
      <input type="text" id="charisma" name="charisma" />
    </div>
    <div>
      <label for="abilities">abilities:</label>
      <textarea v-model="text"></textarea> 
    </div>
    <!-- <div>
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
    </div> -->
    <div>
      <label for="background">Background:</label>
      <textarea v-model="text"></textarea> 
    </div>

    <button type="submit" class="save btn" v-on:click="saveCharacter">Save Character</button>
    
  </form>
  </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      showForm: false,
      picture: null,
      characterName: '',
      creature: '',
      profession: '',
      strength: '',
      dexterity: '',
      constitution: '',
      intelligence: '',
      wisdom: '',
      charisma: '',
      abilities: '',
      // ability2: '',
      // ability3: '',
      // ability4: '',
      background: '',
      user_id: null, // Placeholder for user_id
    };
  },
  methods: {
    toggleForm() {
      this.showForm = !this.showForm;
    },
    async saveCharacter() {
      try {
        const formData = new FormData();
        formData.append('picture', this.picture);
        formData.append('characterName', this.characterName);
        formData.append('creature', this.creature);
        formData.append('profession', this.profession);
        formData.append('strength', this.strength);
        formData.append('dexterity', this.dexterity);
        formData.append('constitution', this.constitution);
        formData.append('intelligence', this.intelligence);
        formData.append('wisdom', this.wisdom);
        formData.append('charisma', this.charisma);
        formData.append('abilities', this.abilities);
        // formData.append('ability2', this.ability2);
        // formData.append('ability3', this.ability3);
        // formData.append('ability4', this.ability4);
        formData.append('background', this.background);
        
      
        
        this.user_id = 3;

        formData.append('user_id', this.user_id);

        await axios.post(`http://localhost:9000/character/${this.user_id}`, formData, {
          headers: {
            'Content-Type': 'multipart/form-data',
          },
        });

        console.log('Character Saved!');
        
        this.picture = null;
        this.characterName = '';
        this.creature = '';
        this.profession = '';
        this.strength = '';
        this.dexterity = '';
        this.constitution = '';
        this.intelligence = '';
        this.wisdom = '';
        this.charisma = '';
        this.abilities = '';
        // this.ability2 = '';
        // this.ability3 = '';
        // this.ability4 = '';
        this.background = '';
        this.showForm = false;
      } catch (error) {
        console.error('Error saving character', error);
      }
    },
  },
  onFileChange(event) {
    this.picture = event.target.files[0];
  },
}
</script>

<style>
.img{
  background-image: url('../loginImages/LoginBG3.png');
  background-repeat: no-repeat;
}
</style>
