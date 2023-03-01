import java.util.Date;

public class Block {

    private int id;
    // Edible field for miners to work on
    private int nonce;
    private long timeStamp;
    private String hash;
    // Pointer of Blockchain Linked-List logic
    private String previousHash;
    private String transaction;

    /**
     * Create an instance of Block.
     *
     * @param id Integer identifier.
     * @param transaction String representation of a transaction.
     * @param previousHash String pointer for a previous existing Hash.
     */
    public Block(int id, String transaction, String previousHash) {
        this.id = id;
        this.transaction = transaction;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        generateHash();

    }

    /**
     * Generate a new Hash for the Block instance.
     */
    public void generateHash(){
        String dataToHash = Integer.toString(id)+previousHash+
                Long.toString(timeStamp)+
                Integer.toString(nonce)+
                transaction.toString();

        this.hash = SHA256Helper.generateHash(dataToHash);
    }

    /**
     * Add one to the current value of nonce.
     */
    public void incrementNonce(){
        this.nonce++;
    }

    /**
     * Get current previousHash value.
     * @return String pointer to the previousHash.
     */
    public String getPreviousHash() {
        return previousHash;
    }

    /**
     * Set previousHash attribute.
     * @param previousHash String pointer for a previous existing Hash.
     */
    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    /**
     * Get current Hash value.
     * @return String SHA-256 Hash.
     */
    public String getHash(){
        return this.hash;
    }

    /**
     * Set Hash attribute.
     * @param hash String SHA-256 Hash.
     */
    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "Block [id="+ id +", hash=" + hash + ", previousHash=" + previousHash + ", transaction=" + transaction + "]";
    }
}
