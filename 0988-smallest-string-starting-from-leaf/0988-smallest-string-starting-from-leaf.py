class Solution:
    def smallestFromLeaf(self, root: Optional[TreeNode]) -> str:
        return self.dfs(root, "")      

    def dfs(self, node, curr_str):
        curr_str = chr(ord('a') + node.val) + curr_str
        if node.left is None and node.right is None:
            return curr_str
        elif node.right is None:
            return self.dfs(node.left, curr_str)
        elif node.left is None:
            return self.dfs(node.right, curr_str)
        else:
            return min(self.dfs(node.left, curr_str), self.dfs(node.right, curr_str))