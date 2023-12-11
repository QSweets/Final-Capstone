<template>
    <div>
        <a
        href="#"
        v-if="showForm === false"
        v-on:click.prevent="showForm = true"
        >Add a Comment</a>

        <form v-on:submit.prevent="addNewComment" v-if="showForm === true">
            <div>
                <label>Name:</label>
                <input type="text" v-model="newComment.commenter"/>
            </div>
            <div>
                <label>Title:</label>
                <input type="text" v-model="newComment.title"/>
            </div>
            <div>
                <label>Comment:</label>
                <textarea v-model="newComment.message"></textarea>
            </div>
            <input type="submit" value="Save" />
            <input type="button" value="Cancel" v-on:click="resetForm" />
        </form>
    </div>
</template>

<script>
export default {
    data() {
        return {
            showForm: false,
            newComment: {},
        };
    },
    methods: {
        addNewComment() {
            this.$store.commit('ADD_COMMENT', this.newComment);
            this.resetForm();
        },
        resetForm() {
            this.showForm = false;
            this.newComment = {};
        },
    },
};
</script>