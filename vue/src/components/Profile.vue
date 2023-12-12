<template>
  <p>This is my Profile page</p>
  <h3>My Party</h3>
  <div class="img">
    <a href="https://www.dnd5eapi.co/"><img src="src\ProfileImages\ProfileWall.png"></a>
  </div>
  <div class="Character-creation-form">
  <button v-on:click="toggleForm">Add Character</button>
  <div v-if="showForm" class="popup-form">
  <form v-on:submit.prevent="submitCharacter">
    <!-- <div>
      <label for="picture">Picture:</label>
      <input type="file" id="picture" name="picture" v-on:change="onFileChange" />
    </div> -->
    <div>
      <label for="character_name">Character Name:</label>
      <input type="text" id="character_name" name="character_name" v-model="character_name" required/>
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
      <label for="class_profession">Profession:</label>
      <select v-model="class_profession" id="profession" required>
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
      <label for="character_strength">Strength:</label>
      <input type="text" id="strength" name="strength" v-model="character_strength" disabled />
    </div>
    <div>
      <label for="character_dexterity">Dexterity:</label>
      <input type="text" id="dexterity" name="dexterity"  v-model="character_dexterity" disabled />
    </div>
    <div>
      <label for="character_constitution">Constitution:</label>
      <input type="text" id="constitution" name="constitution"  v-model="character_constitution" disabled />
    </div>
    <div>
      <label for="character_intelligence">Intelligence:</label>
      <input type="text" id="intelligence" name="intelligence" v-model="character_intelligence" disabled/>
    </div>

    <div>
      <label for="character_wisdom">Wisdom:</label>
      <input type="text" id="wisdom" name="wisdom"  v-model="character_wisdom" disabled />
    </div>
    <div>
      <label for="character_charisma">Charisma:</label>
      <input type="text" id="charisma" name="charisma"  v-model="character_charisma" disabled />
    </div>
    <div>
      <label for="abilities">abilities:</label>
      <textarea v-model="abilities"></textarea> 
    </div>
    <div>
      <label for="background">Background:</label>
      <textarea v-model="background"></textarea> 
    </div>

    <button type="submit" class="save btn" v-on:click="saveCharacter">Save Character</button>
    <div>
    <button v-on:click="rollAllStats">Roll Stats</button>
    </div>

  </form>
  </div>
  </div>
</template>

<script>
import axios from 'axios';

function generateRandomStat(min, max) {
  return Math.floor(Math.random() * (max - min + 1)) + min;
}

export default {
  data() {
    return {
      showForm: false,
      character_name: '',
      creature: '',
      class_profession: '',
      character_strength: generateRandomStat(8, 18),
      character_dexterity: generateRandomStat(8, 18),
      character_constitution: generateRandomStat(8, 18),
      character_intelligence: generateRandomStat(8, 18),
      character_wisdom: generateRandomStat(8, 18),
      character_charisma: generateRandomStat(8, 18),
      abilities: '',
      background: '',
      user_id: null,
    };
  },
  methods: {
    toggleForm() {
      this.showForm = !this.showForm;
    },
    isStatFieldDisabled(statField) {
      return false;
    },
    rollStat(statField) {
      this[statField] = generateRandomStat(8, 18);
    },
    getUserId() {
      return this.$store.state.user.id;
    },
    rollAllStats() {
      this.character_strength = generateRandomStat(8, 18);
      this.character_dexterity = generateRandomStat(8, 18);
      this.character_constitution = generateRandomStat(8, 18);
      this.character_intelligence = generateRandomStat(8, 18);
      this.character_wisdom = generateRandomStat(8, 18);
      this.character_charisma = generateRandomStat(8, 18);
    },
    
    async saveCharacter() {
      try {
       

        const characterData = {
          character_name: this.character_name,
          creature: this.creature,
          class_profession: this.class_profession,
          character_strength: this.character_strength,
          character_dexterity: this.character_dexterity,
          character_constitution: this.character_constitution,
          character_intelligence: this.character_intelligence,
          character_wisdom: this.character_wisdom,
          character_charisma: this.character_charisma,
          abilities: this.abilities,
          background: this.background,
          user_id: this.getUserId(),
        };

        console.log('Character Data:', characterData);

        await axios.post(`http://localhost:9000/characters`, characterData, {
          headers: {
            'Content-Type': 'application/json',
          },
        });

        console.log('Character Saved!');
        this.character_name = '';
        this.creature = '';
        this.class_profession = '';
        this.character_strength = '';
        this.character_dexterity = '';
        this.character_constitution = '';
        this.character_intelligence = '';
        this.character_wisdom = '';
        this.character_charisma = '';
        this.abilities = '';
        this.background = '';
        this.showForm = false;
      } catch (error) {
        console.error('Error saving character', error);
      }
    },
  },
};
</script>

<!-- <style>
.img{
  background-image: url('../loginImages/LoginBG3.png');
  background-repeat: no-repeat;
}
</style> -->
