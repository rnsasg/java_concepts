public class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null)
      return "";

    StringBuilder seq = new StringBuilder();
    seq.append(root.val + "/");

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while (!q.isEmpty()) {
      TreeNode cur = q.poll();

      if (cur.left == null) {
        seq.append("null/");
      } else {
        seq.append(cur.left.val + "/");
        q.offer(cur.left);
      }

      if (cur.right == null) {
        seq.append("null/");
      } else {
        seq.append(cur.right.val + "/");
        q.offer(cur.right);
      }
    }

    return seq.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data.isBlank())
      return null;

    String[] parsedData = data.split("/");

    TreeNode root = new TreeNode(Integer.parseInt(parsedData[0]));

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    int idx = 0;

    while (!q.isEmpty()) {
      TreeNode cur = q.poll();

      idx++;
      if (idx < parsedData.length) {
        if (parsedData[idx].equals("null")) {
          cur.left = null;
        } else {
          cur.left = new TreeNode(Integer.parseInt(parsedData[idx]));
          q.offer(cur.left);
        }
      }

      idx++;
      if (idx < parsedData.length) {
        if (parsedData[idx].equals("null")) {
          cur.right = null;
        } else {
          cur.right = new TreeNode(Integer.parseInt(parsedData[idx]));
          q.offer(cur.right);
        }
      }
    }

    return root;
  }
}