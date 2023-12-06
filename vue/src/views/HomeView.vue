<template>
  <div class="home">
    <h1>Home</h1>
    <router-link v-bind:to="{ name: 'profile' }" v-if="$store.state.token != ''">MyProfile</router-link>
    <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    <NavBar />
  </div>
</template>

<script>
import NavBar from '../components/NavBar.vue';

export default {
  components: {
      NavBar
  }
};
</script>
