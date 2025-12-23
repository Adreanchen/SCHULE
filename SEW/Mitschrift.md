# Forward- vs. Reverse- Engineering in UML
## Forward Engineering:
Aus dem erstellten UML – Diagramm wird der (Java -) Source Code entwickelt.

## Reverse Engineering:
Aus dem bereits entwickelten (Java -) Source Code wird ein UML – Diagramm generiert.

In der Praxis kommt meist eine Mischform der beiden Techniken zum Einsatz: So wird die grobe Klassenstruktur häufig in UML entwickelt, anschließend mittels Forward Engineering der Source code generiert. In weiterer Folge werden z.B. Methoden direkt im Source Code ergänzt und das UML – Diagramm anschließend mittels Reverse Engineering entsprechen aktualisiert.

# Vererbung

Eines der Kernprinzipien der objektorientierten Programmierung ist die Vererbung (inheritance), erlaubt es existierenden Code wiederzuverwenden oder eine bestehende Klasse zu erweitern. Klassen können von anderen Klassen abgeleitet werden und erben damit alle Eigenschaften und Methoden der Oberklasse.
In Java kann eine Klasse nur von einer Oberklasse aberben. (einfach Vererbung)
In Java: public class Airplane extends Aircraft {}
# Vererbung - super

Zum Ausführen der ursprünglichen Methode in der abgeleiteten Klasse wird in der der überschreibenden Methode das Schlüsselwort "super" verwendet.

``````java
class BaseClass {
		public Baseclass() {
				System.out.println("Code in BaseClass#BaseClass");
		}
  
		public void method() {
				System.out.println("Code in BaseClass#method");
		}
  
		public String otherMethod() {
		}
}
``````

``````java
class SubClass extends BaseClass {
		public SubClass() {
				super();
				// zusätzliches Verhalten:
				System.out.println("Code in Subclass#SubClass");
		}
  
  	@Override
  	public void method() {
      	super.method();
      	// zusätzliches Verhalten:
      	System.out.println("Code in SubClass#method");
    }
  
  	public String additionalMethod() {
      	// zusätzliches Verhalten
    }
  
  	SubClass sb = new SubClass();
  	sb.method();
}
``````

---

#  Vererbung - abstrakte Methoden

![basefigure](basefigure.png)

> Problem: Was soll eine draw-Methode bei einer nicht konkreten geometrischen Figur (Base Figure) zeichnen?
>
> Man könnte eine leere Methode einfügen, dies führt zu der Poblematik, dass die Klasse instanzierbar ist, obwohl es nicht sinnvoll ist, da die geometrische Form nicht festgelegt ist.

Genau für solche Fälle eignen sich abstrakte Basisklassen. Diese erlauben es, Methoden vorzugeben, die von Subklassen zu implementieren sind.

Dazu nutzt man Methoden ohne Implementierung. Diese besitzen deswegen auch keinen Block mit Programmzeilen, allerdings eine spezielle Kennzeichnung durch das Schlüsselwort abstract. Man spricht auch von abstrakten Methoden.

``````java
public abstract class BaseFigure {
  	public abstract void draw();
  	public void otherMethod() {
      	// ...
    }
}
``````

``````java
public class Rect extends BaseFigure {
  	public void draw() {
      	// Code zum zeichnen eines Rechtecks
    }
}
``````

``````java
public class Circle extends BaseFigure {
  	public void draw() {
      	// Code zum zeichnen eines Rechtecks
    }
}
``````

# Interfaces (Schnittstellen)

Während bei Vererbung eine Spezialisierung abgebildet wird (z.B. Circle ist eine Spezialisierung von BaseFigure) wird durch Interfaces eine zusätzliche Funktionalität bereitgestellt (z.B. Geometrische Form kann vergrößert werden)

Da eine Klasse mehrere Funktionalitäten besitzen kann, können mehrere Interfaces implementiert werden.

Mit einem Interface wird für ein Objekt beschrieben, was es kann. Im Gegensatz dazu wird mit Vererbung für ein Objekt beschrieben, was es ist.  

<u>Beispiel:</u>

``````java
interface Resizeable {
		public abstract void resize();
}
``````

``````java
class Circle implements Resizeable {
	public void resize () {
		// ...
	}
}
``````

# Fehlerbehandlung mit Exceptions

## Allgemeines

```java
try {
    // int wert = Integer.valueOf("Keine Zahl"); // Number Format Exception
    int wert = Integer.valueOf("10");
    ArrayList <String> nameList = null; // NullPointerException
    nameList.add("Tim");
} catch (NumberFormatExcept nfex) { // Unchecked exception
    System.err.println("Can't parse Integer: " + nfex.getMessage());
} catch (NullPointerException npex) {
    System.err.println("Nullpointerexception aufgetreten");
}
```

Tritt bei der Abarbeitung der Anweisungen des tr-Blocks ein Fehler auf , der eine Exception auslöst, so stoppt die Verarbeitung der Anweisungen im try-Block. Es wird direkt ein auf die Exception ausgelegter catch-Block eingesprungen - sofer ein solcher existiert. Gibt es keinen auf den Typ der Exception passender catch-Block, so wird die Exception so lange an die aufrufenden Methoden weitergegeben (propogiert), bis entweder ein passender catch-Block gefunden oder die main() - Methode erreicht wird und damit die Programmausführung stoppt. 

## Finally

Es gibt bei try-catch einen optionalen finally-Block. Die Anweisungen darin werden immer ausgeführt, egal ob ein Fehler aufgetreten ist oder nicht.

Sinnvoll kann man den finally Block nutzen, um auf jeden Fall benötigte Aufräumarbeiten durchzuführen. 

```java
BufferedReader br = null;
try {
    br = new BufferedReader(new FileReade(filePath));
    while (br.ready()) {
        // Aus Datei lesen
    }
} catch (FileNotFoundException fnfex) {
    // Fehlerbehandlung, wenn Datei nicht gefunden
} catch (IOException ioex) {
    //Fehlerbehandlung, wenn ein IO Problem aufgetreten ist
} finally {
    // "Aufräumen" Stream schließen
    // egal, ob ein Fehler aufgetreten
    // ist oder nicht
    br.close();
}
```



### Exceptions selbst auslösen oder wertergegeben throw und throws

Mit dem Schlüsselwort throw kann explizit eine Exception innerhalb einer Methode ausgelöst werden, die von der aufrufenden Methode abgefangen werden kann. 

```java
protected int squareAdvanced(int value, int lowerBound, int upperBound) throws IllegalArgumentException {
    if (value < lowerBound || value > upperBound) {
        throw new IllegalArgumentException("Out of bounds");
    }
    return value * value;
}
```

Mit dem Schlüsselwort throws, welches die Methodensignatur ergänzt wird angezeigt, dass diese Methode möglicherweise eine netsprechende Exception auslöst, die von der aufrufenden Mehode abgefangen werden muss (checked exception)
