package love.broccolai.crypt.provider;

import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import java.util.Collection;
import love.broccolai.crypt.api.holder.CurrencyHolder;
import love.broccolai.crypt.api.key.Key;
import org.jspecify.annotations.NullMarked;

@NullMarked
public final class ExampleBanks {

    private final Multimap<Key, ExampleBank> holderBanks = MultimapBuilder.hashKeys().arrayListValues().build();

    public void deposit(final CurrencyHolder holder, final Key bankKey, final double amount) {
        ExampleBank bank = this.bank(holder, bankKey);
        bank.balance(bank.balance() + amount);
    }

    public double balance(final CurrencyHolder holder, final Key bankKey) {
        ExampleBank bank = this.bank(holder, bankKey);
        return bank.balance();
    }

    private ExampleBank bank(final CurrencyHolder holder, final Key bankKey) {
        Collection<ExampleBank> banks = this.holderBanks.get(holder.key());
        for (ExampleBank bank : banks) {
            if (bank.key().equals(bankKey)) {
                return bank;
            }
        }

        ExampleBank newBank = new ExampleBank(bankKey);
        this.holderBanks.put(holder.key(), newBank);
        return newBank;
    }
}
