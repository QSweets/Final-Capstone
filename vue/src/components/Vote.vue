<template>
    <div class="voting-form">
    </div>
<div class="voting-actions">
    <button v-on:click="voteForSelectedUsers()">Vote</button>
</div>
<NavBar />
<GlobalLogoHeader />
</template>

<script>
import NavBar from './NavBar.vue';
import GlobalLogoHeader from '../components/GlobalLogoHeader.vue';

export default {
    components: {
        NavBar,
        GlobalLogoHeader,
    },

    data() {
        return {

        }
    }
}
</script>

<style> 

</style>