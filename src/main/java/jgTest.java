JGraphT Visualizations
        via JGraph

        THIS PAGE IS OUT OF DATE
        Modern web browsers don't support applets directly, and JGraphT is dropping support for JGraph and replacing it with JGraphX. If you'd like to help with making this page work again, here is the relevant github issue.
        Demo Applet
        The following applet shows how a JGraphT graph can be visualized using JGraph. Try to play and drag around the vertices and edges to get the feel of it.

        Note: Java 1.3 or above must be installed for this applet to work correctly.


        Java 2 Standard Edition v 1.3 or above is required for this applet.
        Download it from http://java.sun.com.
        a JGraphT graph visualized using JGraph.


        How it Works
        It's very simple: the JGraphT library comes with an adapter that makes JGraphT graphs compatible with JGraph. To visualize a JGraphT graph you just need to initialize JGraph via that adapter.

        Example code:

        // create a JGraphT graph
        ListenableGraph g = new ListenableDirectedGraph( DefaultEdge.class );

        // create a visualization using JGraph, via the adapter
        JGraph jgraph = new JGraph( new JGraphModelAdapter( g ) );
        Is that all?!  Yes, that's all. Any modification now made to the graph g will automatically be reflected by the JGraph component.



        Source Code of the Applet
        The full source code of this demo is listed below and is also included in the JGraphT distribution (download now).


        package org.jgrapht.demo;

        import java.awt.Color;
        import java.awt.Dimension;
        import java.awt.Rectangle;

        import java.util.HashMap;
        import java.util.Map;

        import javax.swing.JApplet;
        import javax.swing.JFrame;

        import org.jgraph.JGraph;
        import org.jgraph.graph.DefaultGraphCell;
        import org.jgraph.graph.GraphConstants;

        import org.jgrapht.ListenableGraph;
        import org.jgrapht.ext.JGraphModelAdapter;
        import org.jgrapht.graph.ListenableDirectedGraph;
        import org.jgrapht.graph.DefaultEdge;

/**
 * A demo applet that shows how to use JGraph to visualize JGraphT graphs.
 *
 * @author Barak Naveh
 *
 * @since Aug 3, 2003
 */
public class JGraphAdapterDemo extends JApplet {
    private static final Color     DEFAULT_BG_COLOR = Color.decode( "#FAFBFF" );
    private static final Dimension DEFAULT_SIZE = new Dimension( 530, 320 );

    //
    private JGraphModelAdapter m_jgAdapter;

    /**
     * @see java.applet.Applet#init().
     */
    public void init(  ) {
        // create a JGraphT graph
        ListenableGraph g = new ListenableDirectedGraph( DefaultEdge.class );

        // create a visualization using JGraph, via an adapter
        m_jgAdapter = new JGraphModelAdapter( g );

        JGraph jgraph = new JGraph( m_jgAdapter );

        adjustDisplaySettings( jgraph );
        getContentPane(  ).add( jgraph );
        resize( DEFAULT_SIZE );

        // add some sample data (graph manipulated via JGraphT)
        g.addVertex( "v1" );
        g.addVertex( "v2" );
        g.addVertex( "v3" );
        g.addVertex( "v4" );

        g.addEdge( "v1", "v2" );
        g.addEdge( "v2", "v3" );
        g.addEdge( "v3", "v1" );
        g.addEdge( "v4", "v3" );

        // position vertices nicely within JGraph component
        positionVertexAt( "v1", 130, 40 );
        positionVertexAt( "v2", 60, 200 );
        positionVertexAt( "v3", 310, 230 );
        positionVertexAt( "v4", 380, 70 );

        // that's all there is to it!...
    }


    private void adjustDisplaySettings( JGraph jg ) {
        jg.setPreferredSize( DEFAULT_SIZE );

        Color  c        = DEFAULT_BG_COLOR;
        String colorStr = null;

        try {
            colorStr = getParameter( "bgcolor" );
        }
        catch( Exception e ) {}

        if( colorStr != null ) {
            c = Color.decode( colorStr );
        }

        jg.setBackground( c );
    }


    private void positionVertexAt( Object vertex, int x, int y ) {
        DefaultGraphCell cell = m_jgAdapter.getVertexCell( vertex );
        Map              attr = cell.getAttributes(  );
        Rectangle        b    = GraphConstants.getBounds( attr );

        GraphConstants.setBounds( attr, new Rectangle( x, y, b.width, b.height ) );

        Map cellAttr = new HashMap(  );
        cellAttr.put( cell, attr );
        m_jgAdapter.edit( cellAttr, null, null, null, null );
    }
}


    Valid HTML 4.01!	© Copyright 2003, by Barak Naveh and Contributors. All rights reserved.	Get JGraphT at SourceForge.net. Fast, secure and Free Open Source software downloads
