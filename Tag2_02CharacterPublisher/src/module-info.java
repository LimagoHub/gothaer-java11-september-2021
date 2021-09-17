import de.gothaer.publisher.CharacterPublisher;
import de.gothaer.publisher.impl.CharacterPublisherImpl;

module characterPublisher {
	exports de.gothaer.publisher;
	requires StringProvider;
	
	uses CharacterPublisher;
	provides CharacterPublisher with CharacterPublisherImpl;
	
}