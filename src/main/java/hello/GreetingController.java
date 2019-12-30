package hello;

// import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.net.InetAddress; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.system.ApplicationPid;


@RestController
public class GreetingController {

	GreetingController() throws Exception {}
	

	private final AtomicLong counter = new AtomicLong();
	private final ConcurrentHashMap<String,AtomicLong> nsMap = new ConcurrentHashMap<>();
	private final String processId = new ApplicationPid().toString();
	private final String hostAddress = InetAddress.getLocalHost().getHostAddress();

	// Compute next Count 
	private long getNextCount() {
		return counter.incrementAndGet();
	}

	// Potential optimization for getNextCount() ?? - Compute next Count using concurrentHashMap 
	private long getNextCountNS(String namespace) {
		AtomicLong counter = nsMap.get(namespace);
		long count = 0l;
		if (counter != null) {  // Existing namespace
			count = counter.incrementAndGet();			
		}
		else { 					// New namespace
			counter = new AtomicLong();
			nsMap.put(namespace,counter);
		}
		return count;
	}

	@RequestMapping("/getId")
	public Greeting greeting(@RequestParam(value="namespace", defaultValue="namespace") String namespace) 
	{	
		// Compute new namespace Id	
	    String nsId = 	namespace + "-" +					// Namespace
						getNextCount() + "-" +				// Counter of number of calls to "/getId"
						System.currentTimeMillis() + "-" +  // Current system time
						processId + "-" +					// Current process Id
						hostAddress;						// IP address of localHost

		return new Greeting(nsId);
	}
}
