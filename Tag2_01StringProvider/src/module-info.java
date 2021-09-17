import de.gothaer.provider.StringSupplier;
import de.gothaer.provider.impl.FileStringSupplier;

module StringProvider {
	
	exports de.gothaer.provider;
	
	uses StringSupplier;
	provides StringSupplier with FileStringSupplier;
}