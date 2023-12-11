<template>
    <div>
        <comment-display 
            v-bind:key="comment.id"
            v-bind:comment="comment" />
    </div>
</template>

<script>
import CommentDisplay from '../components/CommentDisplay.vue';
export default {
    components: {
        CommentDisplay
    }
}
</script>