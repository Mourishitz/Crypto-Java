import java.util.LinkedList;
import java.util.List;

public class BlockChain {

    private List<Block> blockChain;

    public BlockChain() {
        this.blockChain = new LinkedList<>();
    }

    /**
     * Adds a Block in the Blockchain.
     *
     * @param block Instance of a Block.
     */
    public void addBlock(Block block){
        this.blockChain.add(block);
    }

    /**
     * Get all the Blocks in the Blockchain.
     *
     * @return List of Blocks in the chain
     */
    public List<Block> getBlockChain() {
        return this.blockChain;
    }

    /**
     * Get the size of the Blockchain.
     *
     * @return Integer
     */
    public int getSize() {
        return this.blockChain.size();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for(Block block: this.blockChain)
            s.append(block.toString()).append("\n");
        return s.toString();
    }
}
