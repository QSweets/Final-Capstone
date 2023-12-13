<template>
    <div id="background">
    <div class="voting-form">
    </div>
<div class="voting-actions">
    <button id="custom-font" class="vote-btn" v-on:click="voteForSelectedUsers()">Vote</button>
</div>
<NavBar />
</div>
</template>

<script>
import NavBar from './NavBar.vue';



export default {
    components: {
    NavBar
},

    data() {
        return {

        }
    }
}
</script>

<style> 

</style>