<template>
<<<<<<< HEAD
  <div>
    <h1>ProfilePage</h1>
=======
    <div>
      <h1>ProfilePage</h1>
  
      <!-- This is to navigate to the homepage -->
      <router-link to="/" v-if="$store.state.token !== ''">Home</router-link>
      
      <!-- navigate to the "logout" route -->
      <router-link to="/logout" v-if="$store.state.token !== ''">Logout</router-link>

      <Profile />
      <GlobalLogoHeader />
    </div>
  </template>
  
  <script>
  import Profile from '../components/Profile.vue'
  import GlobalLogoHeader from '../components/GlobalLogoHeader.vue';
>>>>>>> b222d202c6c84733e3c94c3ab1dd6f0485273af7

    <!-- This is to navigate to the homepage -->
    <router-link to="/" v-if="$store.state.token !== ''">Home</router-link>

    <!-- navigate to the "logout" route -->
    <router-link to="/logout" v-if="$store.state.token !== ''">Logout</router-link>
    
    <Profile />
    <GlobalLogoHeader />
    <CharacterList :characters="yourCharacters" />
  </div>
</template>

<script>
import axios from 'axios';
import Profile from '../components/Profile.vue'
import GlobalLogoHeader from '../components/GlobalLogoHeader.vue';
import CharacterList from '../components/CharacterList.vue';

export default {
  components: {
    Profile,
    GlobalLogoHeader,
    CharacterList
  },
  data() {
    return {
      yourCharacters: [], // Initialize with an empty array
    };
  },
  created() {
    // Fetch characters from the backend and update yourCharacters
    this.fetchCharacters();
  },
  methods: {
    async fetchCharacters() {
      try {
        // Make an API call to your backend to get characters
        const response = await axios.get(`http://localhost:9000/characters/${user_id}`);

        // Update yourCharacters with the fetched characters
        this.yourCharacters = response.data;
      } catch (error) {
        console.error('Error fetching characters:', error);
      }
    },
  },
};
</script>

<style>
/* Add your styles here */
</style>
