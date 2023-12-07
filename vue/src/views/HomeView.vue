<template>
  <div class="home">
    <h1>Home</h1>
    <router-link v-bind:to="{ name: 'profile' }" v-if="$store.state.token != ''">MyProfile</router-link>
    <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    <NavBar />
    <MOTW />
  </div>
</template>

<script>
import NavBar from '../components/NavBar.vue';
import MOTW from '../components/MOTW.vue';

export default {
  components: {
      NavBar,
      MOTW
  }
};
</script>
