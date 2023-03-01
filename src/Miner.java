public class Miner {

    private int reward;

    /**
     * Mines a Block in the Blockchain.
     *
     * @param block Block.
     * @param blockChain BlockChain.
     */
    public void mine(Block block, BlockChain blockChain) {

        // Proof of Work
        while(!isGoldenHash(block)){
            block.incrementNonce();
            block.generateHash();
        }
        System.out.println(block+" foi minerado");
        System.out.println("Hash: "+block.getHash());

        blockChain.addBlock(block);
        reward += Constants.REWARD;
    }

    /**
     * Check if the Block hash is a valid hash.
     *
     * @param block Block instance.
     * @return true | false
     */
    private boolean isGoldenHash(Block block){
        String leadingZeros = new String(new char[Constants.DIFFICULTY]).replace('\0', '0');

        return block.getHash().substring(0, Constants.DIFFICULTY).equals(leadingZeros);
    }

    /**
     * Create an instance of Block.
     *
     * @return Integer
     */
    public double getReward() {
        return this.reward;
    }
}
