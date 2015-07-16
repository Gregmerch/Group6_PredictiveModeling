class BankAccountTester2 {
        public static void main (String [] args) {
                BankAccount b1 = new BankAccount(100);
                try {
                        b1.withdrawFunds(20);
                } catch (OverDraftException e) {
                        System.out.println("OD: Withdrawal no good -->" +
                                e.getMessage());
                } catch (NullPointerException e) {
                        System.out.println("NP: Withdrawal no good -->" +
                                e.getMessage());
                } catch (Exception e) {
                        System.out.println("EX: Withdrawal no good -->" +
                                e.getMessage());
                } finally {
                        System.out.println("In finally block.");
                }
                int balance = b1.getBalance();
                System.out.println( balance );
        }
}

class OverDraftException extends Exception {
        public OverDraftException (String message) {
                super(message);
        }
}
class BankAccount {
        public void withdrawFunds (int withdrawalAmount) 
        throws ArrayIndexOutOfBoundsException, OverDraftException {
                if (withdrawalAmount <= balance) {
                        System.out.println("Withdrawal worked!");
                        this.balance = this.balance - withdrawalAmount;
                        throw new ArrayIndexOutOfBoundsException();
                } else {
                        System.out.println("Withdrawal failed!");
                        throw new OverDraftException("Withdrawal Kaput!");
                }
        }

        private int balance;
        private static int bankAccountCount = 0;
        public BankAccount(int balance) {
                System.out.println("Constructing bank account ");
                this.balance = balance;
                bankAccountCount++;
        }
        public int getBalance() {
                return balance;
        }
        public void depositFunds (int depositAmount) {
                this.balance = this.balance + depositAmount;
        }
        public static int getBankAccountCount() {
                return bankAccountCount;
        }
}