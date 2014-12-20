Ext.define('com.fer.FormPanel', {
    extend: 'Ext.form.Panel',
    initComponent: function () {
        this.width = 250;
        this.height = 150;
        this.border = false;
        this.header = false;
        this.url = 'UsuarioServlet';
        this.items = [{
                xtype: 'field',
                name: 'nombre',
                fieldLabel: 'Nombre Completo'
            },
            {
                xtype: 'field',
                name: 'usuario',
                fieldLabel: 'Usuario'
            },
            {
                xtype: 'field',
                name: 'password',
                fieldLabel: 'Password'
            }
        ];
        this.buttons = [
            {
                xtype: 'button',
                text: 'Limpiar',
                handler: function () {
                    this.up('form').getForm().reset();
                }
            }, {
                xtype: 'button',
                text: 'Confirmar',
                handler: function () {
                    var formulario = this.up('form').getForm();
                    if (formulario.isValid()) {
                        formulario.submit({
                            success: function (form, action) {
                                Ext.getCmp('gridMda').store.load();
                                
                                Ext.Msg.alert('Se gravo correctamente!');

                            },
                            failure: function () {
                                Ext.Msg.alert('Error al gravar!');

                            }

                        });

                    }
                }


            }
        ];
        this.callParent();
    }

});

