<template>
  <div >
    <h1 class="home">Home</h1>
    <router-link class="profile-link" v-bind:to="{ name: 'profile' }" v-if="$store.state.token != ''">MyProfile</router-link>
    <router-link class="logout-link" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    <NavBar />
    <MOTW />
    <Welcome />
    <GlobalLogoHeader />
  </div>
</template>

<script>
import NavBar from '../components/NavBar.vue';
import MOTW from '../components/MOTW.vue';
import Welcome from '../components/Welcome.vue';
import GlobalLogoHeader from '../components/GlobalLogoHeader.vue';

export default {
  components: {
    NavBar,
    MOTW,
    Welcome,
    GlobalLogoHeader
  }
};
</script>

<style>

</style>