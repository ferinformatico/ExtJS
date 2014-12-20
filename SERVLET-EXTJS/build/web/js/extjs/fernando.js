
Ext.Loader.setPath('com.fer','js/extjs');
Ext.require('Ext.panel.Panel');
Ext.require('com.fer.FormPanel');
Ext.require('Ext.form.Panel');
Ext.require('com.fer.UsuarioModel');

Ext.onReady(function () {

    Ext.create("Ext.panel.Panel", {
      
        width: 500,
        height: 500,
        title: 'Padrastro de Usuarios',
        renderTo: 'idPanel',
        items:[
              Ext.create('com.fer.FormPanel'),
              Ext.create('Ext.grid.Panel',{
                  width:300,
                  height:300,
                  id:'gridMda',
                  store:Ext.create('Ext.data.Store',{
                     model:'com.fer.UsuarioModel',  
                     proxy:{
                         type:'ajax',
                         url:'UsuarioServlet',
                         extraParams:{
                             accion:'listar'
                         },
                         reader:{
                             type:'json',
                             root:'ListadeUsuarios',
                             successProperty:'success'
                        }
                     },
                     autoLoad:true
                  }),
                  columns:[
                      {text:'Nombre',dataIndex:'nombre',flex:1},
                      {text:'Usuario',dataIndex:'usuario',flex:1},
                      {text:'Password',dataIndex:'password',flex:1}
                  ]
              })
        ]

    });




});
