<template>
    <div>
        <h4>{{ comment.commenter }}</h4>
        <h3>{{ comment.title }}</h3>
        <p>{{ comment.message }}</p>
    </div>
</template>

<script>
export default {
    props: ['comment']
}
</script>