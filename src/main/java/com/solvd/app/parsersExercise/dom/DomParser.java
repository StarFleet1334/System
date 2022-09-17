package com.solvd.app.parsersExercise.dom;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomParser {

    public void read(NodeList nodeList) {

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println("Node name : " + node.getNodeName() + " - " +
                        node.getTextContent());

                if (node.hasAttributes()) {
                    NamedNodeMap nodeMap =node.getAttributes();

                    for (int j = 0; j < nodeMap.getLength(); j++) {
                        Node temp = nodeMap.item(j);
                        System.out.println("Attribute name : " + temp.getNodeName() + " - " +
                                "Value : " + temp.getNodeValue());
                    }

                    if (node.hasChildNodes()) {
                        read(node.getChildNodes());
                    }
                }
            }
        }

    }
}
