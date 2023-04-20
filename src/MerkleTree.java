import java.util.List;

public class MerkleTree {

    private List<String> transactions;

    public MerkleTree(List<String> transactions) {
        this.transactions = transactions;
    }


    private String mergeHash(String hash1, String hash2) {
        String mergedHash = hash1 + hash2;

        return SHA256Helper.generateHash(mergedHash);
    }
}
