using System;
using System.Windows.Forms;

namespace CGM1
{
	public partial class GUI : Form
	{
		public TextBox t1;
		public TextBox t2;

		public Button b1;
		public Button b2;

		public GUI()
		{
			InitializeComponent();
		}

		private void closeButton_Click(object sender, EventArgs e)
		{
			Close();
		}

		private void InitializeComponent()
		{
			this.SuspendLayout();
			this.Text = "FormaisTN2";
			this.Size = new Size(1280, 720);
			this.StartPosition = FormStartPosition.CenterScreen;

			t1 = new TextBox();
			t1.Location = new System.Drawing.Point(962, 562);
			t1.Size = new System.Drawing.Size(260, 0);

			b1 = new Button();
			b1.Location = new System.Drawing.Point(962, 594);
			b1.Text = "Analizar";
			b1.Click += new System.EventHandler(b1_Click);

			b2 = new Button();
			b2.Location = new System.Drawing.Point(1064, 594);
			b2.Text = "Limpar";
			b2.Click += new System.EventHandler(b1_Click);

			t2 = new TextBox();
			t2.Location = new System.Drawing.Point(962, 626);
			t2.Size = new System.Drawing.Size(260, 0);


			this.Controls.Add(t1);
			this.Controls.Add(t2);

			this.Controls.Add(b1);
			this.Controls.Add(b2);

			this.ResumeLayout(false);
		}

		public void b1_Click(Object Sender, EventArgs e)
		{
			switch (((Button)Sender).Text)
			{
				case "Analizar":
					
					break;
				case "Limpar":

					break;
			}
		}
	}
}