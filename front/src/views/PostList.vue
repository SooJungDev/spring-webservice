<template>
  <div>
    <div v-for="post in postList" :key="post.id">
      {{post.id}}
      {{post.title}}
      {{post.author}}
      {{post.modifiedDate}}
    </div>
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex';

export default {
  name: 'post-list',
  components: {
  },
  created() {
    this.getPostList();
  },
  props: {
  },
  data() {
    return {
    };
  },
  computed: {
    ...mapState({
      postList: state => state.common.postList,
    }),
  },
  methods: {
    ...mapActions([
      'getPostList',
    ]),
  },
  destroyed() {
    // 등록된 이벤트 해지
    // 메모리 해지
  },
};
</script>
