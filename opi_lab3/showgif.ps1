Add-Type -AssemblyName System.Windows.Forms
Add-Type -AssemblyName System.Drawing

# Создаем форму
$form = New-Object System.Windows.Forms.Form
$form.Text = "GIF Viewer"
$form.Size = New-Object System.Drawing.Size(500, 500)  # Размер окна 500x500 пикселей
$form.StartPosition = "CenterScreen"  # Окно будет центрировано на экране

# Создаем элемент PictureBox для отображения GIF
$pictureBox = New-Object System.Windows.Forms.PictureBox
$pictureBox.ImageLocation = "sisyphus-rael.gif"  # Укажите путь к вашему GIF
$pictureBox.SizeMode = "Zoom"  # Используем режим Zoom, чтобы GIF корректно вписывался в PictureBox
$pictureBox.Dock = "Fill"  # Элемент PictureBox занимает все пространство формы

# Добавляем элемент PictureBox на форму
$form.Controls.Add($pictureBox)

# Показываем форму
$form.ShowDialog()