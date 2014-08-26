all: java

.PHONY: java

java: src/org/mitre/svmp/protocol/SVMPProtocol.java

src/org/mitre/svmp/protocol/SVMPProtocol.java: svmp.proto
	protoc --java_out src/ svmp.proto
