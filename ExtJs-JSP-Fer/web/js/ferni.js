Ext.onReady(function () {

    var fernando = new Ext.data.JsonStore({
        proxy: {
            type: 'ajax',
            url: 'fernando.jsp'
        },
        autoLoad: true,
        fields: [
            {name: 'nombre', type: 'string'},
            {name: 'apellido', type: 'string'},
            {name: 'sexo', type: 'string'}
        ]


    });

    Ext.create('Ext.grid.Panel', {
        title: 'Universitario',
        store: fernando,
        columns: [
            {text: 'Nombre', dataIndex: 'nombre'},
            {text: 'Apellido', dataIndex: 'apellido'},
            {text: 'Sexo', dataIndex: 'sexo'}
        ],
        height: 250,
        width: 450,
        renderTo: Ext.getBody()

    });

});


