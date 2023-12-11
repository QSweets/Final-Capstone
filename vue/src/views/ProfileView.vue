<template>
  <div>
    <h1>ProfilePage</h1>

    <!-- This is to navigate to the homepage -->
    <router-link to="/" v-if="$store.state.token !== ''">Home</router-link>

    <!-- navigate to the "logout" route -->
    <router-link to="/logout" v-if="$store.state.token !== ''">Logout</router-link>
    
    <Profile />
    <GetParty />
    <GlobalLogoHeader />
    <CharacterList :characters="yourCharacters" />
  </div>
</template>

<script>
import axios from 'axios';
import Profile from '../components/Profile.vue'
import GlobalLogoHeader from '../components/GlobalLogoHeader.vue';
import CharacterList from '../components/CharacterList.vue';
import GetParty from '../components/GetParty.vue'

export default {
  components: {
    Profile,
    GlobalLogoHeader,
    CharacterList,
    GetParty
  },
};
</script>

<style>
/* Add your styles here */
</style>
